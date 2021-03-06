/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.remote.service.impl;

import org.springframework.security.access.AccessDeniedException;
import org.yes.cart.domain.dto.CustomerOrderDTO;
import org.yes.cart.domain.dto.CustomerOrderDeliveryDTO;
import org.yes.cart.domain.dto.CustomerOrderDeliveryDetailDTO;
import org.yes.cart.domain.misc.Result;
import org.yes.cart.exception.UnableToCreateInstanceException;
import org.yes.cart.exception.UnmappedInterfaceException;
import org.yes.cart.remote.service.RemoteCustomerOrderService;
import org.yes.cart.service.dto.DtoCustomerOrderService;
import org.yes.cart.service.dto.GenericDTOService;
import org.yes.cart.service.federation.FederationFacade;

import java.util.*;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 15-May-2011
 * Time: 17:22:15
 */
public class RemoteCustomerOrderServiceImpl
        extends AbstractRemoteService<CustomerOrderDTO>
        implements RemoteCustomerOrderService {

    private final FederationFacade federationFacade;

    /**
     * Construct remote service
     *
     * @param customerOrderDTOGenericDTOService dto service to use.
     * @param federationFacade federation facade
     */
    public RemoteCustomerOrderServiceImpl(final GenericDTOService<CustomerOrderDTO> customerOrderDTOGenericDTOService,
                                          final FederationFacade federationFacade) {
        super(customerOrderDTOGenericDTOService);
        this.federationFacade = federationFacade;
    }

    /**
     * {@inheritDoc}
     */
    public List<CustomerOrderDTO> getAll() throws UnmappedInterfaceException, UnableToCreateInstanceException {
        final List<CustomerOrderDTO> all = new ArrayList<CustomerOrderDTO>(super.getAll());
        federationFacade.applyFederationFilter(all, CustomerOrderDTO.class);
        return all;
    }

    /**
     * {@inheritDoc}
     */
    public CustomerOrderDTO getById(final long id) throws UnmappedInterfaceException, UnableToCreateInstanceException {
        if (federationFacade.isManageable(id, CustomerOrderDTO.class)) {
            return super.getById(id);
        } else {
            throw new AccessDeniedException("Access is denied");
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<CustomerOrderDTO> findCustomerOrdersByCriteria(
            final long customerId,
            final String firstName,
            final String lastName,
            final String email,
            final String orderStatus,
            final Date fromDate,
            final Date toDate,
            final String orderNum
    ) throws UnmappedInterfaceException, UnableToCreateInstanceException {
        final List<CustomerOrderDTO> orders = new ArrayList<CustomerOrderDTO>(((DtoCustomerOrderService) getGenericDTOService()).findCustomerOrdersByCriteria(
                customerId,
                firstName,
                lastName,
                email,
                orderStatus,
                fromDate,
                toDate,
                orderNum
        ));
        federationFacade.applyFederationFilter(orders, CustomerOrderDTO.class);
        return orders;
    }

    /**
     * {@inheritDoc}
     */
    public List<CustomerOrderDeliveryDetailDTO> findDeliveryDetailsByOrderNumber(final String orderNum)
            throws UnmappedInterfaceException, UnableToCreateInstanceException {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).findDeliveryDetailsByOrderNumber(orderNum);
        }
        return Collections.emptyList();
    }


    /**
     * {@inheritDoc}
     */
    public Result updateOrderSetConfirmed(String orderNum) {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).updateOrderSetConfirmed(orderNum);
        } else {
            throw new AccessDeniedException("Access is denied");
        }
    }

    /**
     * {@inheritDoc}
     */
    public Result updateOrderSetCancelled(final String orderNum) {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).updateOrderSetCancelled(orderNum);
        } else {
            throw new AccessDeniedException("Access is denied");
        }
    }

    /**
     * {@inheritDoc}
     */
    public Result updateOrderSetCancelledManual(final String orderNum, final String message) {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).updateOrderSetCancelledManual(orderNum, message);
        } else {
            throw new AccessDeniedException("Access is denied");
        }
    }

    /**
     * {@inheritDoc}
     */
    public Result updateExternalDeliveryRefNo(String orderNum, String deliveryNum, String newRefNo) {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).updateExternalDeliveryRefNo(orderNum, deliveryNum, newRefNo) ;
        } else {
            throw new AccessDeniedException("Access is denied");
        }
    }

    /**
     * {@inheritDoc}
     */
    public Result updateDeliveryStatus(final String orderNum, final String deliveryNum,
                                       final String currentStatus, final String destinationStatus) {

        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService())
                .updateDeliveryStatus(orderNum, deliveryNum, currentStatus, destinationStatus);
        } else {
            throw new AccessDeniedException("Access is denied");
        }

    }

    /**
     * {@inheritDoc}
     */
    public Result updateDeliveryStatusManual(final String orderNum, final String deliveryNum,
                                             final String currentStatus, final String destinationStatus,
                                             final String message) {

        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService())
                    .updateDeliveryStatusManual(orderNum, deliveryNum, currentStatus, destinationStatus, message);
        } else {
            throw new AccessDeniedException("Access is denied");
        }

    }

    /** {@inheritDoc} */
    public List<CustomerOrderDeliveryDTO> findDeliveryByOrderNumber(final String orderNum)
            throws UnmappedInterfaceException, UnableToCreateInstanceException {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).findDeliveryByOrderNumber(orderNum);
        }
        return Collections.emptyList();
    }

    /** {@inheritDoc} */
    public List<CustomerOrderDeliveryDTO> findDeliveryByOrderNumber(final String orderNum, final String deliveryNum)
            throws UnmappedInterfaceException, UnableToCreateInstanceException {
        if (federationFacade.isManageable(orderNum, CustomerOrderDTO.class)) {
            return ((DtoCustomerOrderService) getGenericDTOService()).findDeliveryByOrderNumber(orderNum, deliveryNum);
        }
        return Collections.emptyList();
    }

    /** {@inheritDoc} */
    public Map<String, String> getOrderPgLabels(final String locale) {
        return ((DtoCustomerOrderService) getGenericDTOService()).getOrderPgLabels(locale);
    }
}
