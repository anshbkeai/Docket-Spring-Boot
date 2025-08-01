package com.test.macos;

import java.time.LocalDateTime;
import java.util.List;

public class Test {
    private  String  source;
    private  String  type;
    private  String  status;
    private List<String> logs;
    private  Integer records_fetched;
    private  Integer failures;

    public LocalDateTime getLast_sync() {
        return last_sync;
    }

    public void setLast_sync(LocalDateTime last_sync) {
        this.last_sync = last_sync;
    }

    private LocalDateTime last_sync;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Test{" +
                "source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", logs=" + logs +
                ", records_fetched=" + records_fetched +
                ", failures=" + failures +
                ", last_sync=" + last_sync +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }

    public Integer getRecords_fetched() {
        return records_fetched;
    }

    public void setRecords_fetched(Integer records_fetched) {
        this.records_fetched = records_fetched;
    }

    public Integer getFailures() {
        return failures;
    }

    public void setFailures(Integer failures) {
        this.failures = failures;
    }


}
