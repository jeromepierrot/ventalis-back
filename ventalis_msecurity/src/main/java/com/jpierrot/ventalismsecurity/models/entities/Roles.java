package com.jpierrot.ventalismsecurity.models.entities;

public enum Roles {
    ADMIN,
    EMPLOYEE,
    USER,
    /* for SPECIAL cases, NO ACCESS allowed */
    UNKOWN,
    UNAUTHORIZED,
    BANNED
    /* END of SPECIAL cases */

}
