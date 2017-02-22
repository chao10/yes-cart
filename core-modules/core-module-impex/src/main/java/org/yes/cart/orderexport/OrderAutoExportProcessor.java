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

package org.yes.cart.orderexport;

import org.yes.cart.domain.entity.CustomerOrder;

/**
 * User: denispavlov
 * Date: 20/02/2017
 * Time: 11:33
 */
public interface OrderAutoExportProcessor extends Runnable {

    /**
     * Process single order eligible for export.
     *
     * @param customerOrderId order eligible for export
     */
    void processSingleOrder(Long customerOrderId);

    /**
     * Process single order eligible for export.
     *
     * @param customerOrderId order eligible for export
     * @param error error message
     */
    void markFailedOrder(Long customerOrderId, String error);

    /**
     * Register order exporter.
     *
     * @param orderExporter order exporter
     */
    void registerExporter(OrderExporter orderExporter);

}