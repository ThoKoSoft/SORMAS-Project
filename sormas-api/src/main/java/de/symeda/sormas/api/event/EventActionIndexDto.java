/*******************************************************************************
 * SORMAS® - Surveillance Outbreak Response Management & Analysis System
 * Copyright © 2016-2018 Helmholtz-Zentrum für Infektionsforschung GmbH (HZI)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/
package de.symeda.sormas.api.event;

import java.io.Serializable;
import java.util.Date;

import de.symeda.sormas.api.action.ActionPriority;
import de.symeda.sormas.api.action.ActionStatus;
import de.symeda.sormas.api.user.UserReferenceDto;
import de.symeda.sormas.api.utils.jurisdiction.WithJurisdiction;

public class EventActionIndexDto implements WithJurisdiction<EventJurisdictionDto>, Serializable {

	private static final long serialVersionUID = 8231951545991794808L;

	public static final String I18N_PREFIX = "EventAction";

	public static final String EVENT_UUID = "eventUuid";
	public static final String EVENT_TITLE = "eventTitle";
	public static final String EVENT_START_DATE = "eventStartDate";
	public static final String EVENT_END_DATE = "eventEndDate";
	public static final String EVENT_STATUS = "eventStatus";
	public static final String ACTION_TITLE = "actionTitle";
	public static final String ACTION_CREATION_DATE = "actionCreationDate";
	public static final String ACTION_CHANGE_DATE = "actionChangeDate";
	public static final String ACTION_STATUS = "actionStatus";
	public static final String ACTION_PRIORITY = "actionPriority";
	public static final String ACTION_REPLYING_USER = "actionReplyingUser";

	private String eventUuid;
	private String eventTitle;
	private Date eventStartDate;
	private Date eventEndDate;
	private EventStatus eventStatus;
	private String actionTitle;
	private Date actionCreationDate;
	private Date actionChangeDate;
	private ActionStatus actionStatus;
	private ActionPriority actionPriority;
	private UserReferenceDto actionReplyingUser;
	private EventJurisdictionDto jurisdiction;

	public EventActionIndexDto(
		String eventUuid,
		String eventTitle,
		Date eventStartDate,
		Date eventEndDate,
		EventStatus eventStatus,
		String actionTitle,
		Date actionCreationDate,
		Date actionChangeDate,
		ActionStatus actionStatus,
		ActionPriority actionPriority,
		String actionReplyingUserUuid,
		String actionReplyingUserFirstName,
		String actionReplyingUserLastName,
		String eventRegionUuid,
		String eventDistrictUuid,
		String eventCommunityUuid,
		String eventReportingUserUuid,
		String eventSurveillanceOfficerUuid) {

		this.eventUuid = eventUuid;
		this.eventTitle = eventTitle;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.eventStatus = eventStatus;
		this.actionTitle = actionTitle;
		this.actionCreationDate = actionCreationDate;
		this.actionChangeDate = actionChangeDate;
		this.actionStatus = actionStatus;
		this.actionPriority = actionPriority;
		this.actionReplyingUser = new UserReferenceDto(actionReplyingUserUuid, actionReplyingUserFirstName, actionReplyingUserLastName, null);
		this.jurisdiction =
			new EventJurisdictionDto(eventReportingUserUuid, eventSurveillanceOfficerUuid, eventRegionUuid, eventDistrictUuid, eventCommunityUuid);
	}

	public String getEventUuid() {
		return eventUuid;
	}

	public void setEventUuid(String eventUuid) {
		this.eventUuid = eventUuid;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public Date getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public Date getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public EventStatus getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getActionTitle() {
		return actionTitle;
	}

	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}

	public Date getActionCreationDate() {
		return actionCreationDate;
	}

	public void setActionCreationDate(Date actionCreationDate) {
		this.actionCreationDate = actionCreationDate;
	}

	public Date getActionChangeDate() {
		return actionChangeDate;
	}

	public void setActionChangeDate(Date actionChangeDate) {
		this.actionChangeDate = actionChangeDate;
	}

	public ActionStatus getActionStatus() {
		return actionStatus;
	}

	public void setActionStatus(ActionStatus actionStatus) {
		this.actionStatus = actionStatus;
	}

	public ActionPriority getActionPriority() {
		return actionPriority;
	}

	public void setActionPriority(ActionPriority actionPriority) {
		this.actionPriority = actionPriority;
	}

	public UserReferenceDto getActionReplyingUser() {
		return actionReplyingUser;
	}

	public void setActionReplyingUser(UserReferenceDto actionReplyingUser) {
		this.actionReplyingUser = actionReplyingUser;
	}

	public EventJurisdictionDto getJurisdiction() {
		return jurisdiction;
	}
}