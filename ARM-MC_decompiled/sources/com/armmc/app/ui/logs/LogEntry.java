package com.armmc.app.ui.logs;

import com.armmc.app.LogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/armmc/app/ui/logs/LogEntry;", "", "timestamp", "", "level", "Lcom/armmc/app/ui/logs/LogLevel;", "message", "<init>", "(Ljava/lang/String;Lcom/armmc/app/ui/logs/LogLevel;Ljava/lang/String;)V", "getTimestamp", "()Ljava/lang/String;", "getLevel", "()Lcom/armmc/app/ui/logs/LogLevel;", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: LogEntry.kt */
public final class LogEntry {
    private final LogLevel level;
    private final String message;
    private final String timestamp;

    public static /* synthetic */ LogEntry copy$default(LogEntry logEntry, String str, LogLevel logLevel, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logEntry.timestamp;
        }
        if ((i & 2) != 0) {
            logLevel = logEntry.level;
        }
        if ((i & 4) != 0) {
            str2 = logEntry.message;
        }
        return logEntry.copy(str, logLevel, str2);
    }

    public final String component1() {
        return this.timestamp;
    }

    public final LogLevel component2() {
        return this.level;
    }

    public final String component3() {
        return this.message;
    }

    public final LogEntry copy(String str, LogLevel logLevel, String str2) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(logLevel, "level");
        Intrinsics.checkNotNullParameter(str2, LogManager.EXTRA_MESSAGE);
        return new LogEntry(str, logLevel, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEntry)) {
            return false;
        }
        LogEntry logEntry = (LogEntry) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) logEntry.timestamp) && this.level == logEntry.level && Intrinsics.areEqual((Object) this.message, (Object) logEntry.message);
    }

    public int hashCode() {
        return (((this.timestamp.hashCode() * 31) + this.level.hashCode()) * 31) + this.message.hashCode();
    }

    public String toString() {
        String str = this.timestamp;
        LogLevel logLevel = this.level;
        return "LogEntry(timestamp=" + str + ", level=" + logLevel + ", message=" + this.message + ")";
    }

    public LogEntry(String str, LogLevel logLevel, String str2) {
        Intrinsics.checkNotNullParameter(str, "timestamp");
        Intrinsics.checkNotNullParameter(logLevel, "level");
        Intrinsics.checkNotNullParameter(str2, LogManager.EXTRA_MESSAGE);
        this.timestamp = str;
        this.level = logLevel;
        this.message = str2;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final LogLevel getLevel() {
        return this.level;
    }

    public final String getMessage() {
        return this.message;
    }
}
