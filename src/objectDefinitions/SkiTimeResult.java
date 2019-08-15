package objectDefinitions;

import java.time.LocalTime;
import java.util.Objects;

public class SkiTimeResult implements Comparable<SkiTimeResult> {
    private LocalTime skiTimeResult;

    public SkiTimeResult(LocalTime skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public LocalTime getSkiTimeResult() {
        return skiTimeResult;
    }

    public void setSkiTimeResult(LocalTime skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkiTimeResult)) return false;
        SkiTimeResult that = (SkiTimeResult) o;
        return skiTimeResult == ((SkiTimeResult) o).skiTimeResult;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skiTimeResult);
    }

    @Override
    public int compareTo(SkiTimeResult o) {
        return skiTimeResult.compareTo(o.getSkiTimeResult());
    }

    @Override
    public String toString() {
        return "" + skiTimeResult;
    }
}
