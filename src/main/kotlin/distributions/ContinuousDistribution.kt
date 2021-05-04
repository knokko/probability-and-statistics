package distributions

import base.computeIntegral
import java.lang.Double.max
import java.lang.Double.min

class ContinuousDistribution(val f: (Double) -> Double, val lowerBound: Double? = null, val upperBound: Double? = null) {

    fun chanceBetween(lowerBound: Double? = null, upperBound: Double? = null): Double {
        val combinedLowerBound: Double? = if (this.lowerBound == null) {
            lowerBound;
        } else if (lowerBound == null) {
            this.lowerBound;
        } else {
            max(lowerBound, this.lowerBound);
        }

        val combinedUpperBound: Double? = if (this.upperBound == null) {
            upperBound;
        } else if (upperBound == null) {
            this.upperBound;
        } else {
            min(upperBound, this.upperBound);
        }

        return computeIntegral(f, combinedLowerBound, combinedUpperBound)
    }
}
