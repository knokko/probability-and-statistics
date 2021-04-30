package distributions

class BernoulliDistribution(successChance: Double): BinomialDistribution(1, successChance)