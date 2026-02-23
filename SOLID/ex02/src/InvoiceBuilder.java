import java.util.*;

public class InvoiceBuilder {

    public String build(
            String invoiceId,
            String customerType,
            List<OrderLine> lines,
            Map<String, MenuItem> menu,
            BillAmount amt
    ) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoiceId).append("\n");

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format(
                    "- %s x%d = %.2f\n",
                    item.name, l.qty, lineTotal
            ));
        }

        double taxPct = TaxRules.taxPercent(customerType);

        out.append(String.format("Subtotal: %.2f\n", amt.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, amt.tax));
        out.append(String.format("Discount: -%.2f\n", amt.discount));
        out.append(String.format("TOTAL: %.2f\n", amt.total));

        return InvoiceFormatter.identityFormat(out.toString());
    }
}