public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public final ExportResult help(ExportRequest req) {
        if (req == null)
            throw new IllegalArgumentException("request cannot be null");
        if (req.title == null)
            throw new IllegalArgumentException("title cannot be null");

        ExportResult result = export(req);

        if (result == null || result.bytes == null)
            throw new IllegalStateException("invalid export result");

        return result;
    }
    public abstract ExportResult export(ExportRequest req);
}