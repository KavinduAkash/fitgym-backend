package com.ijse.fitgym.constants.nativeQuaries;

public class NativeQuaries {
    public static final String GET_ADMIN_DETAILS_BY_ID = "SELECT * FROM tbl_fg_admin_user u " +
            "NATURAL JOIN tbl_fg_auth a " +
            "WHERE u.admin_id=?1 " +
            "AND u.admin_id = a.admin_id";
}
