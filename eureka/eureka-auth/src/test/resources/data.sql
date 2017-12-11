INSERT INTO `users` (`user_id`, `username`, `email`,`password`, `enabled`, `created`, `modified`)
VALUES
    (1,'root','root@admin.grp','$2a$12$3uGBNkzQ0HWKE/BeiSk6seTUZ37iE5OePNzlZOB4RiwEk3vpwfQXG',1,'2017-10-16 13:14:45','2017-10-16 14:31:44');
    
INSERT INTO `authorities` (`username`, `authority`)
VALUES
    ('root','ROLE_ADMIN'),
    ('root','ROLE_USER');
    
INSERT INTO `oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
VALUES
    ('client',NULL,'nice-to-have','web,app','password,authorization_code,refresh_token',NULL,NULL,NULL,NULL,NULL,NULL);
    