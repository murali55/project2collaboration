package org.in.dataAccessObj;

import org.in.persistanceClzs.ProfilePicture;

public interface ProfilePictureDao {
void saveOrUpdateProfilePicture(ProfilePicture profilePicture);
ProfilePicture getProfilePicture(String email);
}