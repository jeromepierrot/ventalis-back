/* ConnexionProperties.java */
/* change setting according to SMTP, IMAP and POP3 provider settings */
// TODO : not tested yet
package com.jpierrot.ventalismmail.services;

public interface ConnectionProperties {
    /* Pour git repository - A remplacer par les paramètre du serveur mail */
/*    static final String SMTP_HOST = "smtp-***********.***********";
    static final String SMTP_USER = "***********@***********";
    static final String IMAP_ACCOUNT = "imap-***********.***********";
    static final String SMTP_PASSWORD = "***********";*/

    static final String POP_SERVER = "pop-***********.***********";
    static final String POP_USER_ACCOUNT = "***********@***********";
    static final String POP_USER_PASSWORD = "***********";
}
