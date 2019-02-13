package org.in.dataAccessObj;

import org.in.persistanceClzs.User;

public interface UserDao 
{
void userRegistration(User user);
boolean isEmailUnique(String mail);
boolean isPhoneNbrUnique(String phoneNbr);
User login(User user );
void updateUser(User validUser);
User getUser(String email);
}
