package jalse.actions;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public interface Scheduler<T> {

    boolean cancel(final UUID action);

    boolean isActive(final UUID action);

    default UUID schedule(final Action<T> action) {

	return schedule(action, 0L, TimeUnit.NANOSECONDS);
    }

    UUID schedule(final Action<T> action, final long initialDelay, final long period, final TimeUnit unit);

    default UUID schedule(final Action<T> action, final long initialDelay, final TimeUnit unit) {

	return schedule(action, initialDelay, 0L, unit);
    }
}
