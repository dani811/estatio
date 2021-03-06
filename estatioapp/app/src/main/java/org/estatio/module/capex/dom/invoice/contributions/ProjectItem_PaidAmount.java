package org.estatio.module.capex.dom.invoice.contributions;

import java.math.BigDecimal;
import java.util.function.Function;

import javax.inject.Inject;
import javax.jdo.annotations.Column;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.Contributed;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.estatio.module.capex.dom.invoice.IncomingInvoice;
import org.estatio.module.capex.dom.invoice.IncomingInvoiceItem;
import org.estatio.module.capex.dom.invoice.IncomingInvoiceItemRepository;
import org.estatio.module.capex.dom.project.ProjectItem;

/**
 * TODO: although this could currently be inlined, we expect to factor out project from incoming invoice, in which case this will be a typical contribution across modules.
 */
@Mixin
public class ProjectItem_PaidAmount {

    private final ProjectItem projectItem;
    public ProjectItem_PaidAmount(ProjectItem projectItem){
        this.projectItem = projectItem;
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(contributed = Contributed.AS_ASSOCIATION)
    @Column(scale = 2)
    public BigDecimal paidAmount(){
        return sum(IncomingInvoice::getNetAmount);
    }

    private BigDecimal sum(final Function<IncomingInvoice, BigDecimal> x) {
        return incomingInvoiceItemRepository.findByProjectAndCharge(projectItem.getProject(), projectItem.getCharge()).stream()
                .filter(i->i.getClass().isAssignableFrom(IncomingInvoiceItem.class))
                .map(i->(IncomingInvoice) i.getInvoice())
                .filter(i->i.getPaidDate()!=null)
                .map(x)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Inject
    IncomingInvoiceItemRepository incomingInvoiceItemRepository;
}
