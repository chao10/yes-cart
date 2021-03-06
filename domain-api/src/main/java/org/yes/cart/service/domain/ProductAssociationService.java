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

package org.yes.cart.service.domain;

import org.yes.cart.domain.entity.ProductAssociation;

import java.util.List;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 11:13:01
 */
public interface ProductAssociationService
        extends GenericService<ProductAssociation> {

    /**
     * Get all product associations.
     *
     * @param productId product primary key
     * @return list of product associations
     */
    List<ProductAssociation> findProductAssociations(Long productId);

    /**
     * Get all product associations by association type.
     *
     * @param productId       product primary key
     * @param associationCode association code [up, cross, etc]
     * @return list of product associations
     */
    List<ProductAssociation> findProductAssociations(Long productId, String associationCode);

    /**
     * Get all product associations by association type.
     *
     * @param productId       product primary key
     * @param associationCode association code [up, cross, etc]
     * @return list of product associations ids
     */
    List<Long> getProductAssociationsIds(Long productId, String associationCode);

}
