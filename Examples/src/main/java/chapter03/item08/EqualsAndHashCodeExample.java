package chapter03.item08;

import java.util.Arrays;

public class EqualsAndHashCodeExample {
    private String name;
    private double score;
    private String[] tags;

    public EqualsAndHashCodeExample(String name, double score, String[] tags) {
        this.name = name;
        this.score = score;
        this.tags = tags;
    }

    @Override public boolean equals(Object o) {
        // 1. 자기 자신인지 검사
        if (o == this) return true;

        // 2. 자료형 검사
        if (!(o instanceof EqualsAndHashCodeExample)) return false;

        // 3. 자료형 변환
        EqualsAndHashCodeExample other = (EqualsAndHashCodeExample) o;

        // canEqual 검사
        if (!other.canEqual((Object) this)) return false;

        // 4. 중요 필드 비교
        if (this.getName() == null ? other.getName() != null : !this.getName().equals(other.getName())) return false;
        if (Double.compare(this.score, other.score) != 0) return false;
        if (!Arrays.deepEquals(this.tags, other.tags)) return false;
        return false;

    }

    @Override public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long temp1 = Double.doubleToLongBits(this.score);
        result = (result*PRIME) + (this.name == null ? 43 : this.name.hashCode());
        result = (result*PRIME) + (int)(temp1 ^ (temp1 >>> 32));
        result = (result*PRIME) + Arrays.deepHashCode(this.tags);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof EqualsAndHashCodeExample;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String[] getTags() {
        return tags;
    }

}
