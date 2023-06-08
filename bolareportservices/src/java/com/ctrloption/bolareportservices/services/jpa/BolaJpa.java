package com.ctrloption.bolareportservices.services.jpa;

import com.ctrloption.bolareportservices.entities.bolareports.Payments;
import com.ctrloption.bolareportservices.entities.bolareports.Revenuecollectors;
import com.ctrloption.bolareportservices.models.Collector;
import com.ctrloption.bolareportservices.models.ReportsModel;
import com.ctrloption.bolareportservices.restmodels.bola.RevenueCollectionSummaryRequest;
import com.ctrloption.bolareportservices.utils.AppLogger;
import com.ctrloption.jpa2.CrudController;
import com.ctrloption.jpa2.Enviroment;
import com.ctrloption.jpa2.QryBuilder;
import com.ctrloption.models.DateRange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author Daud
 */
@Stateless
public class BolaJpa extends CrudController implements Serializable {

    @PersistenceContext
    private EntityManager em;
    private static final Logger log = Logger.getLogger(BolaJpa.class.getName());

    @PostConstruct
    private void init() {
        setEm(em);
        setEnviroment(Enviroment.JAVA_EE);
    }

    public int runQry(String qry) {
        int affectedResult = em.createQuery(qry).executeUpdate();
        String msg = affectedResult + " Updates on runing : " + qry;
        log.info(msg);
        return affectedResult;
    }

    public List fetchPayments(RevenueCollectionSummaryRequest request) {

        try {
            AppLogger.printPayload(log, "final request", request);
            QryBuilder builder = new QryBuilder(em, Payments.class);
            if (request.getSearchBy().equalsIgnoreCase("DR")) {
                DateRange dateRange = new DateRange();
                dateRange.setToDate(request.getEndDate());
                dateRange.setFromDate(request.getStartDate());
                builder.addDateRange(dateRange, "datepaid");
            } else {
                builder.addStringQryParam("revcollector.revcollectorID", request.getSearchValue(), QryBuilder.ComparismCriteria.EQUAL);
            }
            builder.orderByAsc("revenueCollection.revcolid");
//            builder.orderByAsc("datepaid");

            List<Payments> listOfPayments = builder.buildQry().getResultList();
            log.info(" quering getBranchMembers " + builder.getQryInfo());
            if (listOfPayments.isEmpty()) {
                log.info("No payment data found");
                return Collections.EMPTY_LIST;
            }
            List<ReportsModel> dataList = new ArrayList();
            for (Payments eachPayment : listOfPayments) {
                dataList.add(new ReportsModel(eachPayment));
            }
            return dataList;
        } catch (Exception e) {
            return null;
        }

    }

    public List fetchCollectors() {
        try {
            QryBuilder builder = new QryBuilder(em, Revenuecollectors.class);
            builder.orderByAsc("revcollector");
            List<Revenuecollectors> listOfPayments = builder.buildQry().getResultList();
            log.info(" quering collectors " + builder.getQryInfo());
            if (listOfPayments.isEmpty()) {
                log.info("No collectors data found");
                return Collections.EMPTY_LIST;
            }
            List<Collector> collectors = new ArrayList<>();
            if (!listOfPayments.isEmpty()) {
                for (Revenuecollectors eachOne : listOfPayments) {
                    Collector info = new Collector(eachOne);
                    collectors.add(info);
                }
            }
            return collectors;
        } catch (Exception e) {
            return null;
        }

    }
}
