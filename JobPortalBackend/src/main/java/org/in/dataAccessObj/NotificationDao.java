package org.in.dataAccessObj;

import java.util.List;

import org.in.persistanceClzs.Notification;

public interface NotificationDao {
void addNotification(Notification notification);
	
	List<Notification> getAllNotificationsNotViewed(String email);
	
	Notification getNotification(int notificationId);
	
	void updateNotificactionViewedStatus(int notificationId);
}
