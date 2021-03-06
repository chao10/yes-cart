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

package org.yes.cart.web.page.component.filterednavigation.impl;

import org.yes.cart.domain.query.LuceneQueryFactory;
import org.yes.cart.service.domain.ProductService;

/**
 * User: denispavlov
 * Date: 13-09-28
 * Time: 12:26 AM
 */
public class AbstractFilteredNavigationSupportImpl {

    private final LuceneQueryFactory luceneQueryFactory;
    private final ProductService productService;

    public AbstractFilteredNavigationSupportImpl(final LuceneQueryFactory luceneQueryFactory,
                                                 final ProductService productService) {
        this.luceneQueryFactory = luceneQueryFactory;
        this.productService = productService;
    }

    public LuceneQueryFactory getLuceneQueryFactory() {
        return luceneQueryFactory;
    }

    public ProductService getProductService() {
        return productService;
    }

}
