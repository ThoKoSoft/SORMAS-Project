package de.symeda.sormas.app.validation;

import java.util.Date;

import de.symeda.sormas.api.utils.DateHelper;
import de.symeda.sormas.api.visit.VisitDto;
import de.symeda.sormas.app.R;
import de.symeda.sormas.app.backend.contact.Contact;
import de.symeda.sormas.app.core.Callback;
import de.symeda.sormas.app.core.NotificationContext;
import de.symeda.sormas.app.databinding.FragmentVisitEditLayoutBinding;

public final class VisitValidator {

    public static void initializeVisitValidation(final Contact contact, final FragmentVisitEditLayoutBinding contentBinding) {
        if (contact != null) {
            Callback.IAction<NotificationContext> visitDateTimeCallback = new Callback.IAction<NotificationContext>() {
                public void call(NotificationContext notificationContext) {
                    Date visitDateTime = (Date) contentBinding.visitVisitDateTime.getValue();
                    Date contactReferenceDate = contact.getLastContactDate() != null ? contact.getLastContactDate() : contact.getReportDateTime();
                    if (visitDateTime.before(contactReferenceDate) && DateHelper.getDaysBetween(visitDateTime, contactReferenceDate) > VisitDto.ALLOWED_CONTACT_DATE_OFFSET) {
                        contentBinding.visitVisitDateTime.enableErrorState(notificationContext,
                                contact.getLastContactDate() != null ? R.string.validation_visit_date_time_before_contact_date
                                        : R.string.validation_visit_date_time_before_report_date);
                    } else if (contact.getFollowUpUntil() != null && visitDateTime.after(contact.getFollowUpUntil()) && DateHelper.getDaysBetween(contact.getFollowUpUntil(), visitDateTime) > VisitDto.ALLOWED_CONTACT_DATE_OFFSET) {
                        contentBinding.visitVisitDateTime.enableErrorState(notificationContext,
                                R.string.validation_visit_date_time_after_followup);
                    } else {
                        contentBinding.visitVisitDateTime.disableErrorState();
                    }
                }
            };

            contentBinding.visitVisitDateTime.setValidationCallback(visitDateTimeCallback);
        }
    }

}
