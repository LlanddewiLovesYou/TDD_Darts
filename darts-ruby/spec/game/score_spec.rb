require File.join('game', 'score')
require File.join('models', 'miss')
require File.join('models', 'pass')
require File.join('models', 'throw_single')
require File.join('models', 'throw_double')
require File.join('models', 'throw_triple')
require File.join('models', 'throw_inner_bullseye')
require File.join('models', 'throw_outer_bullseye')

describe Score do
  subject { Score.new }
end