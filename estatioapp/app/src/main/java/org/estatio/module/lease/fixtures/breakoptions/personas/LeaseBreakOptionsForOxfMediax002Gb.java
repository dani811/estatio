/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
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
package org.estatio.module.lease.fixtures.breakoptions.personas;

import org.estatio.module.lease.dom.Lease;
import org.estatio.module.lease.dom.breaks.BreakExerciseType;
import org.estatio.module.lease.dom.breaks.BreakType;
import org.estatio.module.lease.fixtures.LeaseBreakOptionsAbstract;
import org.estatio.module.lease.fixtures.lease.personas.LeaseForOxfMediaX002Gb;
import org.estatio.module.lease.fixtures.leaseitems.rent.personas.LeaseItemAndLeaseTermForRentForOxfMediax002Gb;
import org.estatio.module.lease.fixtures.leaseitems.servicecharge.personas.LeaseItemAndLeaseTermForServiceChargeForOxfMediax002Gb;
import org.estatio.module.lease.fixtures.leaseitems.turnoverrent.personas.LeaseItemAndLeaseTermForTurnoverRentForOxfMediax002Gb;

public class LeaseBreakOptionsForOxfMediax002Gb extends LeaseBreakOptionsAbstract {

    public static final String LEASE_REF = LeaseForOxfMediaX002Gb.REF;

    @Override
    protected void execute(ExecutionContext executionContext) {

        // prereqs
        executionContext.executeChild(this, new LeaseItemAndLeaseTermForRentForOxfMediax002Gb());
        executionContext.executeChild(this, new LeaseItemAndLeaseTermForServiceChargeForOxfMediax002Gb());
        executionContext.executeChild(this, new LeaseItemAndLeaseTermForTurnoverRentForOxfMediax002Gb());

        // exec
        final Lease lease = leaseRepository.findLeaseByReference(LEASE_REF);
        newBreakOptionPlusYears(
                lease, 5, "6m", BreakType.FIXED, BreakExerciseType.MUTUAL, null, executionContext);
        newBreakOptionAtEndDate(
                lease, "6m", BreakType.ROLLING, BreakExerciseType.MUTUAL, null, executionContext);
    }

}
