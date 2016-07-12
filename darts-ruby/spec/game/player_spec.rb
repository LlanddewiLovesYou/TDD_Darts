require File.join('game', 'player')
require File.join('models', 'throw', 'miss')
require File.join('models', 'throw', 'pass')
require File.join('models', 'throw', 'single')
require File.join('models', 'throw', 'double')
require File.join('models', 'throw', 'triple')
require File.join('models', 'throw', 'inner_bullseye')
require File.join('models', 'throw', 'outer_bullseye')

describe Player do
  subject { Player.new }
end