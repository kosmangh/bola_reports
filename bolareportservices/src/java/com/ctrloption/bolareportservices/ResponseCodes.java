package com.ctrloption.bolareportservices;

import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class ResponseCodes {

    private static final Logger log = Logger.getLogger(ResponseCodes.class.getName());

    public static final String SUCCESS = "000";
    public static final String FAILED = "999";
    public static final String LANG_REQUIRED = "E00";
    public static final String MERCHANT_ID_REQUIRED = "E01";
    public static final String INVALID_CREDENTIALS = "E02";
    public static final String ERROR_SERVICING_REQUEST = "E05";
    public static final String PIN_LENGTH_NOT_ALLOWED = "E06";
    public static final String ADDRESS_REQUIRED = "E07";
    public static final String PIN_CHANGE_FAILED = "E08";
    public static final String CONTACT_PERSON = "E10";
    public static final String BRANCH_DELETION_FAILED = "E11";
    public static final String WAREHOUSE_UPDATE_FAILED = "E12";
    public static final String PROFILE_INACTIVE = "E13";
    public static final String TERMINAL_ID_REQUIRED = "E14";
    public static final String TIN_NO_REQUIRED = "E15";
    public static final String MERCHANT_INFO_NOT_FOUND = "E16";
    public static final String MERCHANT_ACTIVATION_OPT_MSG = "M17";
    public static final String OPT_REQUIRED = "E18";
    public static final String MERCHANT_NOT_ACTIVATED = "E19";
    public static final String MERCHANT_RESET_OPT_MSG = "M23";
    public static final String SELL_PRICE_REQUIRED = "EDB";
    public static final String MERCHANT_PIN_RESET_FAILED = "E37";
    public static final String RECORD_ID_REQUIRED = "E40";
    public static final String MERCHANT_ACCOUNT_ACTIVATION_FAILED = "E41";
    public static final String START_DATE_REQUIRED = "E42";
    public static final String END_DATE_REQUIRED = "E43";
    public static final String NO_TRANSACTION = "E49";

    public static final String DELETED_BY_REQUIRED = "E44";
    public static final String PRODUCT_NAME_REQUIRED = "E45";
    public static final String SEARCH_BY_REQUIRED = "E46";
    public static final String SEARCH_VALUE_REQUIRED = "E47";

    public static final String CATEGORY_NOT_FOUND = "E48";
    public static final String NO_RECORD_FOUND = "E50";

    public static final String PURCHASE_STATUS_REQUIRED = "E51";
    public static final String WAREHOUSE_REQUIRED = "E52";

    public static final String DEPARTMENT_CREATION_FAILED = "E53";
    public static final String PURCHASE_NOT_FOUND = "E54";
    public static final String COST_PRICE_REQUIRED = "E55";

    public static final String STATUS_REQUIRED = "E56";

    public static final String BRAND_UPDATE_FAILED = "E57";
    public static final String PRODUCT_NOT_FOUND = "E58";

    public static final String USER_ROLE_CREATION_FAILED = "E59";
    public static final String STAFF_CREATION_FAILED = "E60";

    public static final String NO_WAREHOUSE_FOUND = "E61";
    public static final String PRODUCT_UPDATE_FAILED = "E62";

    public static final String BRANCH_CREATION_FAILED = "E63";
    public static final String COMPANY_NOT_FOUND = "E64";

    public static final String WAREHOUSE_DELETION_FAILED = "E65";

    public static final String CATEGORY_DELETION_FAILED = "E66";
    public static final String PRODUCT_DELETION_FAILED = "E67";
    public static final String BRAND_NOT_FOUND = "E68";
    public static final String PRODUCT_REQUIRED = "E69";
    public static final String BRAND_CREATION_FAILED = "E70";
    public static final String CATEGORY_REQUIRED = "E71";

    public static final String THIRD_PARTY_SYSTEM_ERROR = "E73";
    public static final String WAREHOUSE_NOT_FOUND = "E74";

    public static final String SAME_CR_DR_ACCOUNT = "E75";
    public static final String SURNAME_REQUIRED = "E76";

    public static final String CATEGORY_CREATION_FAILED = "E77";

    public static final String BRANCH_NAME_REQUIRED = "E78";

    public static final String COMPANY_ID_REQUIRED = "E79";
    public static final String TRANSACTION_LIMIT_EXCEEDED = "E80";
    public static final String COMPANY_ACCOUNT_INACTIVE = "E81";
    public static final String INACTIVE_ACCOUNT = "E82";
    public static final String LOCAL_TO_FOREIGN_NOT_ALLOWED = "E83";

    public static final String RESTRICTION_ON_ACCOUNT = "E84";
    public static final String SENDING_RECEIVE_COUNTRY_NOT_SAME = "E85";
    public static final String XPRESS_ACCOUNT_NOT_FOUND = "E86";

    public static final String BRAND_NAME_REQUIRED = "E87";

    public static final String COMPANY_CREATION_FAILED = "E88";
    public static final String OTHER_NAMES_REQUIRED = "E89";
    public static final String UNIT_REQUIRED = "E90";
    public static final String ALERT_QTY_REQUIRED = "E91";

    public static final String CATEGORY_UPDATE_FAILED = "E92";
    public static final String WAREHOUSE_NAME = "E93";
    public static final String MONTHLY_LIMIT_EXCEEDED = "E94";
    public static final String YEARLY_LIMIT_EXCEEDED = "E95";

    public static final String TRANSFER_NOT_ALLOWED_FROM_CHANNEL = "E96";

    public static final String PRODUCT_CREATION_FAILED = "E97";

    public static final String SUPPLIER_NOT_FOUND = "E98";
    public static final String SUPPLIER_UPDATE_FAILED = "E99";
    public static final String CONTACT_ADMINSTRATOR = "E100";

    public static final String MERCHANT_EXIST = "M01";
    public static final String USER_ACCOUNT_CREATION_FAILED = "M02";
    public static final String MERCHANT_ALREADY_ACTIVATED = "M03";
    public static final String SUPPLIER_NAME_REQUIRED = "M04";
    public static final String INVOICE_NO_REQUIRED = "M05";

    public static final String SUPPLIER_CREATION_FAILED = "M06";
    public static final String SUPPLIER_DELETION_FAILED = "M07";
    public static final String VAT_NO_REQUIRED = "M08";
    public static final String WAREHOUSE_CREATION_FAILED = "M09";
    public static final String CITY_REQUIRED = "M10";
    public static final String LANGUAGE_NOT_SUPPORTED = "M11";
    public static final String MODIFIED_REQUIRED = "E01";
    public static final String CREATED_BY_REQUIRED = "E02";
    public static final String CREATED_BY_ROLE_REQUIRED = "E03";
    public static final String EMAIL_REQUIRED = "E04";
    public static final String EMAIL_INVALID = "E05";
    public static final String FULL_NAME_REQUIRED = "E06";
    public static final String SOURCE_CODE_REQUIRED = "E07";
    public static final String ROLE_LEVEL_REQUIRED = "E08";
    public static final String CONTACT_NO_REQUIRED = "E09";
    public static final String MOBILE_NO_REQUIRED = "E10";
    public static final String USER_ROLE_REQUIRED = "E11";
    public static final String USERNAME_REQUIRED = "E12";
    public static final String MODIFIED_BY_ROLE_REQUIRED = "E13";
    public static final String REQUEST_TOKEN_REQUIRED = "E14";
    public static final String mnoOnboardingFailed = "E15";
    public static final String userAuthorizationFailed = "E16";
    public static final String userAccountUpdateFailed = "E17";
    public static final String mnoUpdateFailed = "E18";
    public static final String MERCHANT_NAME_REQUIRED = "E19";
    public static final String PERSONAL_MAIL_REQUIRED = "E20";
    public static final String MERCHANT_CITY_REQUIRED = "E21";
    public static final String COMPANY_UPDATE_FAILED = "E22";
    public static final String SHORT_NAME_REQUIRED = "E23";
    public static final String COMPANY_NAME_REQUIRED = "E24";
    public static final String LOCATION_REQUIRED = "E25";
    public static final String COMPANY_REQUIRED = "E26";
    public static final String TERMINAL_ID_GENERATION_FAILED = "E27";
    public static final String REQUEST_ID_REQUIRED = "E28";
    public static final String pendingAuthorization = "E29";
    public static final String noRecordFound = "E30";
    public static final String MERCHANT_ADDRESS_REQUIRED = "E31";
    public static final String MERCHANT_ALREADY_EXIST = "E32";
    public static final String MERCHANT_EMAIL_REQUIRED = "E33";
    public static final String MERCHANT_MOBILE_NO_REQUIRED = "E34";
    public static final String REMARKS_REQUIRED = "E35";
    public static final String PASSWORD_REQUIRED = "E36";
    public static final String VERIFY_STATUS_REQUIRED = "E37";
    public static final String REQUIRED_TYPE_REQUIRED = "E38";
    public static final String QR_STRING_BASE64_FAILED = "E39";
    public static final String TERMINAL_CREATION_FAILED = "E40";
    public static final String NO_BRANCH_FOUND = "E41";
    public static final String noSystemRolesFound = "E42";
    public static final String VERIFY_BY_REQUIRED = "E43";
    public static final String MERCHANT_CREATION_FAILED = "E45";
    public static final String NO_PRODUCTS_FOUND = "E49";

    public static String getAppMsg(String msgCode, String langCode) {
        if (null == langCode || langCode.isEmpty()) {
//            log.info("Lang is empty or null;default to EN");
            langCode = "EN";
        }
        log.info("msg code " + msgCode + " lang " + langCode);
        Locale userLocale = new Locale(langCode.toLowerCase(), langCode.toUpperCase());
        ResourceBundle messages = ResourceBundle.getBundle("messages", userLocale);
        String msg = messages.getString(msgCode);
//        System.out.println("Msg:: " + msg);
        return msg;
    }

    public static String getAppMsg(String msgCode) {
        try {
            Locale userLocale = new Locale("EN", "EN");
            ResourceBundle messages = ResourceBundle.getBundle("messages", userLocale);
            String msg = messages.getString(msgCode);
            return msg;
        } catch (Exception e) {
            return "Unable to find language resource for " + msgCode;
        }
    }
}
