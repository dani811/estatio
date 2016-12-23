/*
 *  Copyright 2012-date Eurocommercial Properties NV
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.app.services.metamodel;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.bookmark.Bookmark;
import org.apache.isis.core.metamodel.services.metamodel.MetaModelServiceDefault;

@DomainService(menuOrder = "100", nature = NatureOfService.DOMAIN)
public class MetaModelServiceForEstatio extends MetaModelServiceDefault {

    @Override
    public Sort sortOf(final Bookmark bookmark) {
        try {
            return super.sortOf(bookmark);
        } catch (Exception e) {
            return Sort.UNKNOWN;
        }
    }

}
