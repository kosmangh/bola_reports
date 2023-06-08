/**
 * Author:  dainoo
 * Created: Feb 21, 2023
 */
CREATE OR REPLACE PACKAGE merchant_portal_pkg IS

  -- Author  : AAHWIRENG
  -- Created : 1/28/2023 1:19:34 PM
  -- Purpose : 

    PROCEDURE pr_get_merchant_info (
        p_merchant_code VARCHAR2,
        resp_dat_cur    OUT SYS_REFCURSOR,
        err_code        OUT VARCHAR2,
        err_msg         OUT VARCHAR2
    );

    FUNCTION fn_insert_merch_account (
        p_login_id VARCHAR2,
        p_password VARCHAR2,
        err_code   OUT VARCHAR2,
        err_msg    OUT VARCHAR2
    ) RETURN NUMBER;

    FUNCTION fn_get_merchant (
        p_search     VARCHAR2,
        resp_dat_cur OUT SYS_REFCURSOR,
        err_code     OUT VARCHAR2,
        err_msg      OUT VARCHAR2
    ) RETURN NUMBER;

    FUNCTION fn_upd_merchant_pin (
        p_merchant_id VARCHAR2,
        p_pin         VARCHAR2,
        err_code      OUT VARCHAR2,
        err_msg       OUT VARCHAR2
    ) RETURN NUMBER;

    FUNCTION fn_change_merchant_pin (
        p_merchant_id VARCHAR2,
        p_old_pin     VARCHAR2,
        p_new_pin     VARCHAR2,
        err_code      OUT VARCHAR2,
        err_msg       OUT VARCHAR2
    ) RETURN NUMBER;

    PROCEDURE log_otp_token (
        me_id       IN VARCHAR2,
        tken        IN VARCHAR2,
        tken_status IN VARCHAR2,
        err_code    OUT VARCHAR2,
        err_msg     OUT VARCHAR2
    );

    PROCEDURE pr_otp_validate (
        p_merchant_id VARCHAR2,
        p_token_id    VARCHAR2,
        out_result    OUT VARCHAR2
    );

    PROCEDURE activate_merchant (
        login_id    IN VARCHAR2,
        pwd         IN VARCHAR2,
        out_result4 OUT VARCHAR2
    );

    PROCEDURE pr_merchant_pin_update (
        p_psword   VARCHAR2,
        p_login_id VARCHAR2,
        result_out OUT VARCHAR2
    );

    FUNCTION fn_validate_terminal (
        p_merch_id VARCHAR2,
        p_terminal VARCHAR2,
        p_password VARCHAR2,
        err_code   OUT VARCHAR2,
        err_msg    OUT VARCHAR2
    ) RETURN NUMBER;

    PROCEDURE pr_get_terminal_info (
        p_terminal_id  VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    );

    PROCEDURE pr_get_terminalby_merchid (
        p_merchant_id  VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    );

    PROCEDURE pr_get_trans_date_range (
        p_terminal_id  VARCHAR2,
        p_start        VARCHAR2,
        p_end          VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    );
  /*function fn_get_trans_info(p_merch_id varchar2,
                             p_start    varchar2,
                             p_end      varchar2,
                             p_json_txt out varchar2,
                             err_code   out varchar2,
                             err_msg    out varchar2) return number;*/

    FUNCTION fn_authenticate_merchant (
        p_id           VARCHAR2,
        p_pin          VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        p_type         OUT VARCHAR2,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    ) RETURN NUMBER;

    PROCEDURE pr_get_merch_terminals (
        p_merch_id     VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    );

    FUNCTION fn_merchant_dashboard (
        p_merch_id     VARCHAR2,
        p_start        VARCHAR2,
        p_end          VARCHAR2,
        p_sum          OUT VARCHAR2,
        p_volume       OUT VARCHAR2,
        p_total        OUT VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    ) RETURN NUMBER;

    PROCEDURE pr_get_merch_info (
        p_merch_code   VARCHAR2,
        p_resp_dat_cur OUT SYS_REFCURSOR,
        p_type         OUT VARCHAR2,
        err_code       OUT VARCHAR2,
        err_msg        OUT VARCHAR2
    );

END merchant_portal_pkg;
