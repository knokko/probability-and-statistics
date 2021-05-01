package distributions

class GeometricDistribution(successChance: Double): NegativeBinomialDistribution(successChance, 1L)