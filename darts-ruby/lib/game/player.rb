require File.join('game', 'player')
require File.join('models', 'miss')
require File.join('models', 'pass')
require File.join('models', 'throw_single')
require File.join('models', 'throw_double')
require File.join('models', 'throw_triple')
require File.join('models', 'throw_inner_bullseye')
require File.join('models', 'throw_outer_bullseye')

class Player

  def score
    raise NotImplementedError.new 'Method not implemented'
  end

  def turn(firstThrow, secondThrow, thirdThrow)
    raise NotImplementedError.new 'Method not implemented'
  end

end