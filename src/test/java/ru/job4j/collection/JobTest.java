package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenComparatorByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("Impl task", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Impl task", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNameAndPriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNameAndPriority.compare(
                new Job("Bug fix", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndDescPriority() {
        Comparator<Job> cmpNameandDescPriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNameandDescPriority.compare(
                new Job("Bug fix", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndPriority() {
        Comparator<Job> cmpDescNameAndPriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpDescNameAndPriority.compare(
                new Job("Bug fix", 0),
                new Job("Check style", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpDescNameAndDescPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpDescNameAndDescPriority.compare(
                new Job("Bug fix", 0),
                new Job("Bug fix", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}