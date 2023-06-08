/**
 * Author:  dainoo
 * Created: Feb 21, 2023
 */
create or replace package body merchant_portal_pkg is

  procedure pr_get_merchant_info(p_merchant_code varchar2,
                                 resp_dat_cur    out sys_refcursor,
                                 err_code        out varchar2,
                                 err_msg         out varchar2) as
  begin
    open resp_dat_cur for
      select mv_merchants.*, mv_merch_terminal_new.*
        from mv_merchants
        join mv_merch_terminal_new
          on mv_merchants.merchant_code = mv_merch_terminal_new.merchant_id
       where mv_merchants.merchant_code = p_merchant_code;
  
    err_code := '000';
    err_msg  := 'SUCESS';
  
  exception
    when others then
      err_code := '001';
      err_msg  := 'Exception occured -> ' || sqlerrm;
  end pr_get_merchant_info;

  function fn_insert_merch_account(p_login_id varchar2,
                                   p_password varchar2,
                                   err_code   out varchar2,
                                   err_msg    out varchar2) return number as
    row_id rowid;
  begin
    insert into mv_merchant_activations
      (login_id, password, account_type, status, last_login_date)
    values
      (p_login_id, p_password, 'M', 'Y', sysdate)
    returning rowid into row_id;
  
    if row_id is not null then
      commit;
      err_code := '000';
      err_msg  := 'TRUE';
      return 0;
    else
      rollback;
      err_code := '001';
      err_msg  := 'FALSE';
      return 1;
    end if;
  
  exception
    when others then
      rollback;
      err_code := '001';
      err_msg  := 'Attempt to insert provider details failed==>> ' ||
                  sqlerrm;
      return 1;
  end fn_insert_merch_account;

  function fn_get_merchant(p_search     varchar2,
                           resp_dat_cur out sys_refcursor,
                           err_code     out varchar2,
                           err_msg      out varchar2) return number as
    v_cnt number;
  begin
    select count(*)
      into v_cnt
      from mv_merchant_activations
     where login_id = p_search
       and status = 'Y';
  
    if (v_cnt) > 0 then
      err_code := '000';
      err_msg  := 'merchant already activated';
    
      open resp_dat_cur for
        select * from mv_merchant_activations where login_id = p_search;
      return 0;
    end if;
  
    err_code := '001';
    err_msg  := 'Merchant does not exist';
    return 1;
  end fn_get_merchant;

  function fn_upd_merchant_pin(p_merchant_id varchar2,
                               p_pin         varchar2,
                               err_code      out varchar2,
                               err_msg       out varchar2) return number as
    row_id rowid;
  begin
    update mv_merchant_activations
       set password = p_pin
     where login_id = p_merchant_id
    returning rowid into row_id;
  
    if row_id is not null then
      commit;
      err_code := '000';
      err_msg  := 'TRUE';
      return 0;
    else
      rollback;
      err_code := '001';
      err_msg  := 'FALSE';
      return 1;
    end if;
  exception
    when others then
      rollback;
      err_code := '005';
      err_msg  := 'Unknown exception ==> ' || sqlerrm;
  end fn_upd_merchant_pin;

  function fn_change_merchant_pin(p_merchant_id varchar2,
                                  p_old_pin     varchar2,
                                  p_new_pin     varchar2,
                                  err_code      out varchar2,
                                  err_msg       out varchar2) return number as
    row_id rowid;
  begin
    update mv_merchant_activations
       set password = p_new_pin
     where login_id = p_merchant_id
       and password = p_old_pin
    returning rowid into row_id;
  
    if row_id is not null then
      commit;
      err_code := '000';
      err_msg  := 'TRUE';
      return 0;
    else
      rollback;
      err_code := '001';
      err_msg  := 'FALSE';
      return 1;
    end if;
  
  exception
    when others then
      rollback;
      err_code := '005';
      err_msg  := 'Unknown exception ==> ' || sqlerrm;
  end fn_change_merchant_pin;
  
    PROCEDURE log_otp_token (
        me_id       IN VARCHAR2,
        tken        IN VARCHAR2,
        tken_status IN VARCHAR2,
        err_code    OUT VARCHAR2,
        err_msg     OUT VARCHAR2
    ) IS
    BEGIN
        INSERT INTO mv_merchant_otps (
            id,
            merchant_id,
            token,
            request_date,
            token_status
        ) VALUES (
            merchant_id_seq.NEXTVAL,
            me_id,
            tken,
            sysdate,
            tken_status
        );

        COMMIT;
        err_code := '000';
        err_msg := 'Sucess';
    EXCEPTION
        WHEN OTHERS THEN
            err_code := '001';
            err_msg := 'Failed' || sqlerrm;
            ROLLBACK;
    END log_otp_token;

  procedure pr_otp_validate(p_merchant_id varchar2,
                            p_token_id    varchar2,
                            out_result    out varchar2) as
    v_token_id    varchar(800);
    v_merchant_id varchar(50);
    row_id        rowid;
  begin
    select token, id
      into v_token_id, v_merchant_id
      from mv_merchant_otps
     where id = (select max(id)
                   from mv_merchant_otps
                  where merchant_id = p_merchant_id
                    and token_status = 'NEW');
                    
    if v_token_id = p_token_id then
      UPDATE mv_merchant_otps
         SET TOKEN_STATUS = 'USED', DATE_USED = SYSDATE
       where id = v_merchant_id
      returning rowid into row_id;
      if row_id is not null then
        commit;
        out_result := 'TRUE';
      else
        rollback;
        out_result := 'FALSE';
      end if;
    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      out_result := 'FALSE';
  end pr_otp_validate;

  PROCEDURE activate_merchant(login_ID    IN VARCHAR2,
                              PWD         IN VARCHAR2,
                              out_result4 OUT VARCHAR2) AS
    row_id ROWID;
  BEGIN
  
    UPDATE mv_merchant_activations
       SET password = PWD, status = 'Y'
     WHERE login_id = login_ID
    RETURNING ROWID INTO row_id;
    IF row_id IS NOT NULL THEN
      COMMIT;
      out_result4 := 'TRUE';
    ELSE
      ROLLBACK;
      out_result4 := 'FALSE';
    END IF;
  EXCEPTION
    WHEN OTHERS THEN
      out_result4 := 'FALSE';
      ROLLBACK;
  END activate_merchant;

  procedure pr_merchant_pin_update(p_psword   varchar2,
                                   p_login_id varchar2,
                                   result_out out varchar2) as
    row_id rowid;
  begin
    update mv_merchant_activations
       set password = p_psword
     where login_id = p_login_id
    returning rowid into row_id;
  
    if row_id is not null then
      commit;
      result_out := 'TRUE';
    else
      rollback;
      result_out := 'FALSE';
    end if;
  exception
    when others then
      result_out := 'update failed ' || sqlerrm;
      rollback;
  end pr_merchant_pin_update;

  function fn_validate_terminal(p_merch_id varchar2,
                                p_terminal varchar2,
                                p_password varchar2,
                                err_code   out varchar2,
                                err_msg    out varchar2) return number as
    row_id rowid;
    v_cnt  number;
    v_cnt2 number;
  begin
    /**/
    select count(*)
      into v_cnt
      from mv_merchant_activations
     where login_id = p_terminal;
  
    if v_cnt > 0 then
      err_code := '004';
      err_msg  := 'Terminal already activated';
      return 1;
    else
      select count(*)
        into v_cnt2
        from mv_merch_terminal_new
       where merchant_id = p_merch_id
         and terminal_id = p_terminal;
    end if;
  
    if v_cnt2 > 0 then
      insert into mv_merchant_activations
        (login_id, password, account_type, status, last_login_date)
      values
        (p_terminal, p_password, 'T', 'Y', sysdate)
      returning rowid into row_id;
    
      if row_id is not null then
        commit;
        err_code := '000';
        err_msg  := 'TRUE';
        return 0;
      else
        rollback;
        err_code := '001';
        err_msg  := 'FALSE';
        return 1;
      end if;
    else
      err_code := '003';
      err_msg  := 'Invalid terminal id -> ' || p_terminal;
      return 1;
    end if;
  exception
    when others then
      err_code := '005';
      err_msg  := 'Exception occured -> ' || sqlerrm;
      return 1;
  end fn_validate_terminal;

  procedure pr_get_terminal_info(p_terminal_id  varchar2,
                                 p_resp_dat_cur out sys_refcursor,
                                 err_code       out varchar2,
                                 err_msg        out varchar2) as
    v_cnt number;
  begin
    select count(*)
      into v_cnt
      from mv_merchant_activations
     where login_id = p_terminal_id
       and account_type = 'T';
  
    if v_cnt > 0 then
      open p_resp_dat_cur for
        select * from terminals where terminal_id = p_terminal_id;
      err_code := '000';
      err_msg  := 'TRUE';
    else
      err_code := '001';
      err_msg  := 'FALSE';
    end if;
  exception
    when others then
      err_code := '005';
      err_msg  := 'Unknown exception -> ' || sqlerrm;
  end pr_get_terminal_info;

  procedure pr_get_terminalBy_merchId(p_merchant_id  varchar2,
                                      p_resp_dat_cur out sys_refcursor,
                                      err_code       out varchar2,
                                      err_msg        out varchar2) as
  begin
    open p_resp_dat_cur for
      select * from terminals where merchant_id = p_merchant_id;
  
    err_code := '000';
    err_msg  := 'TRUE';
  exception
    when others then
      err_code := '001';
      err_msg  := 'FALSE -> ' || sqlerrm;
  end pr_get_terminalBy_merchId;

  procedure pr_get_trans_date_range(p_terminal_id  varchar2,
                                    p_start        varchar2,
                                    p_end          varchar2,
                                    p_resp_dat_cur out sys_refcursor,
                                    err_code       out varchar2,
                                    err_msg        out varchar2) as
  begin
    open p_resp_dat_cur for
      select mv_merchant_payment_log.terminal_id,
             mv_merch_terminal_new.terminal_name,
             mv_merchant_payment_log.payment_ref_no,
             mv_merchant_payment_log.amount,
             mv_merchant_payment_log.narration,
             mv_merchant_payment_log.request_date
        from mv_merchant_payment_log
        join mv_merch_terminal_new
          on mv_merchant_payment_log.terminal_id =
             mv_merch_terminal_new.terminal_id
       where mv_merchant_payment_log.terminal_id = p_terminal_id
         and trunc(request_date) between to_date(p_start, 'MM/DD/YYYY') and
             to_date(p_end, 'MM/DD/YYYY');
  
    err_code := '000';
    err_msg  := 'TRUE';
  
  exception
    when others then
      err_code := '001';
      err_msg  := 'Exception occured -> ' || sqlerrm;
  end pr_get_trans_date_range;

  /*function fn_get_trans_info(p_merch_id varchar2,
                             p_start    varchar2,
                             p_end      varchar2,
                             p_json_txt out varchar2,
                             err_code   out varchar2,
                             err_msg    out varchar2) return number as
    v_sum    number;
    v_volume number;
    v_num    number;
    v_cnt    number;
  begin
    \* Get total number of terminals*\
    select count(*)
      into v_cnt
      from mv_merch_terminal_new
     where merchant_id = p_merch_id;
  
    if v_cnt > 0 then
      \*Get total number of terminals relating to merchant provided*\
      select count(*)
        into v_num
        from mv_merchant_payment_log
       where merchant_id = p_merch_id;
    
      \*Get total volume of transactions made within date range provided*\
      select count(amount)
        into v_volume
        from mv_merchant_payment_log
       where merchant_id = p_merch_id
         and trunc(request_date) between to_date(p_start, 'MM/DD/YYYY') and
             to_date(p_end, 'MM/DD/YYYY');
    
      \*Get the sum of all transactions made within given date range*\
      select sum(amount)
        into v_sum
        from mv_merchant_payment_log
       where merchant_id = p_merch_id
         and trunc(request_date) between to_date(p_start, 'MM/DD/YYYY') and
             to_date(p_end, 'MM/DD/YYYY');
    
      p_json_txt := '{ "totalTerminals": ' || v_num || ', "transVolume": ' ||
                    v_volume || ', "transValue": ' || v_sum || '}';
    
      err_code := '000';
      err_msg  := 'SUCCESS';
      return 0;
    else
      err_code := '001';
      err_msg  := 'Terminal relating to ' || p_merch_id ||
                  ' does not exist';
      return 1;
    end if;
  
  exception
    when others then
      err_code := '005';
      err_msg  := 'Exception occured -> ' || sqlerrm;
      return 1;
  end fn_get_trans_info;*/

  function fn_authenticate_merchant(p_id           varchar2,
                                    p_pin          varchar2,
                                    p_resp_dat_cur out sys_refcursor,
                                    p_type         out varchar2,
                                    err_code       out varchar2,
                                    err_msg        out varchar2)
    return number as
    v_cnt      number;
    v_type     varchar2(10);
    v_aff_name varchar2(80);
  begin
  
    select count(*)
      into v_cnt
      from mv_merchant_activations
     where login_id = p_id
       and password = p_pin;
  
    if v_cnt > 0 then
      select account_type
        into v_type
        from mv_merchant_activations
       where login_id = p_id
         and password = p_pin;
    
      if v_type = 'M' then
        select affiliate_name
          into v_aff_name
          from mvp_affiliates
         where affiliate_code =
               (select affiliate_code
                  from mv_merchants
                 where merchant_code = p_id);
      
        open p_resp_dat_cur for
          select mm.affiliate_code,
                 mm.branch_code,
                 mm.merchant_code,
                 v_aff_name affiliate_name,
                 mm.email,
                 mm.merchant_name,
                 mma.last_login_date
            from mv_merchants mm
            join mv_merchant_activations mma
              on mma.login_id = mm.merchant_code
           where mm.merchant_code = p_id;
      
        err_code := '000';
        p_type   := 'MERCHANT';
        err_msg  := 'SUCCESS';
        return 0;
      elsif v_type = 'T' then
        open p_resp_dat_cur for
          select mmt.aff_code,
                 mmt.terminal_id,
                 mmt.terminal_name,
                 mmt.branch_code,
                 mmt.merch_name,
                 mmt.merchant_id,
                 mmt.email_address,
                 mma.last_login_date
            from mv_merch_terminal_new mmt
            join mv_merchant_activations mma
              on mmt.terminal_id = mma.login_id
           where mmt.terminal_id = p_id;
      
        err_code := '000';
        p_type   := 'TERMINAL';
        err_msg  := 'SUCCESS';
        return 0;
      end if;
    else
      err_code := '001';
      err_msg  := 'Account does not exist / not activated';
      return 1;
    end if;
  
  exception
    when others then
      err_code := '005';
      err_msg  := 'Exception occured -> ' || sqlerrm;
      return 1;
  end fn_authenticate_merchant;

  procedure pr_get_merch_terminals(p_merch_id     varchar2,
                                   p_resp_dat_cur out sys_refcursor,
                                   err_code       out varchar2,
                                   err_msg        out varchar2) as
  begin
    open p_resp_dat_cur for
      select terminal_id,
             terminal_name,
             email_address,
             qrcode,
             terminal_mobile_no,
             status,
             aff_code
        from mv_merch_terminal_new
       where merchant_id = p_merch_id;
  
    err_code := '000';
    err_msg  := 'SUCCESS';
  
  exception
    when others then
      err_code := '001';
      err_msg  := 'Exception occured -> ' || sqlerrm;
  end pr_get_merch_terminals;

  function fn_merchant_dashboard(p_merch_id     varchar2,
                                 p_start        varchar2,
                                 p_end          varchar2,
                                 p_sum          out varchar2,
                                 p_volume       out varchar2,
                                 p_total        out varchar2,
                                 p_resp_dat_cur out sys_refcursor,
                                 err_code       out varchar2,
                                 err_msg        out varchar2) return number as
    v_terminal_sum number;
    v_trans_volume number;
    v_trans_total  number;
    v_cnt          number;
  begin
    select count(*)
      into v_cnt
      from mv_merchant_activations
     where login_id = p_merch_id;
  
    if v_cnt > 0 then
    
      select count(terminal_id)
        into v_terminal_sum
        from mv_merch_terminal_new
       where merchant_id = p_merch_id;
    
      select sum(amount)
        into v_trans_total
        from mv_merchant_payment_log
       where merchant_id = p_merch_id
         and trunc(request_date) between to_date(p_start, 'MM-DD-YYYY') and
             to_date(p_end, 'MM-DD-YYYY');
    
      select count(*)
        into v_trans_volume
        from mv_merchant_payment_log
       where merchant_id = p_merch_id
         and trunc(request_date) between to_date(p_start, 'MM-DD-YYYY') and
             to_date(p_end, 'MM-DD-YYYY');
    
      p_sum    := nvl(v_terminal_sum, '0');
      p_volume := nvl(v_trans_volume, '0');
      p_total  := nvl(v_trans_total, '0');
    
      open p_resp_dat_cur for
        select mmp.terminal_id,
               mmt.terminal_name,
               mmp.affiliate_code,
               sum(mmp.amount) as amount,
               count(mmp.amount) as volume
          from mv_merchant_payment_log mmp
          join mv_merch_terminal_new mmt
            on mmp.merchant_id = mmt.merchant_id
         where mmp.merchant_id = p_merch_id
           and trunc(mmp.request_date) between
               to_date(p_start, 'MM-DD-YYYY') and
               to_date(p_end, 'MM-DD-YYYY')
         group by mmp.terminal_id, mmt.terminal_name, mmp.affiliate_code;
    
      err_code := '000';
      err_msg  := 'SUCCESS';
      return 0;
    else
      err_code := '001';
      err_msg  := 'Merchant not activated';
      return 1;
    end if;
  exception
    when others then
      err_code := '004';
      err_msg  := 'Exception occured -> ' || sqlerrm;
      return 1;
  end fn_merchant_dashboard;

  procedure pr_get_merch_info(p_merch_code   varchar2,
                              p_resp_dat_cur out sys_refcursor,
                              p_type         out varchar2,
                              err_code       out varchar2,
                              err_msg        out varchar2) as
    v_type     varchar2(10);
    v_aff_name varchar2(80);
  begin
    select account_type
      into v_type
      from mv_merchant_activations
     where login_id = p_merch_code;
  
    if (v_type) = 'M' then
    
      select affiliate_name
        into v_aff_name
        from mvp_affiliates
       where affiliate_code =
             (select affiliate_code
                from mv_merchants
               where merchant_code = p_merch_code);
    
      open p_resp_dat_cur for
        select mm.affiliate_code,
               mm.branch_code,
               mm.merchant_code,
               v_aff_name affiliate_name,
               mm.email,
               mm.merchant_name,
               mma.last_login_date
          from mv_merchants mm
          join mv_merchant_activations mma
            on mma.login_id = mm.merchant_code
         where mm.merchant_code = p_merch_code;
    
      err_code := '000';
      p_type   := 'MERCHANT';
      err_msg  := 'SUCCESS';
    elsif (v_type) = 'T' then
      open p_resp_dat_cur for
        select mmt.aff_code,
               mmt.aff_code,
               mmt.terminal_id,
               mmt.terminal_name,
               mmt.branch_code,
               mmt.merchant_id,
               mmt.merch_name,
               mmt.email_address,
               mma.last_login_date
          from mv_merch_terminal_new mmt
          join mv_merchant_activations mma
            on mmt.terminal_id = mma.login_id
         where mmt.terminal_id = p_merch_code;
    
      err_code := '000';
      p_type   := 'TERMINAL';
      err_msg  := 'SUCCESS';
    else
      err_code := '001';
      err_msg  := 'Merchant / Terminal does not exist';
    end if;
  
  exception
    when others then
      err_code := '004';
      err_msg  := 'Exception occured -> ' || sqlerrm;
  end pr_get_merch_info;
end merchant_portal_pkg;

