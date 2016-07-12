require File.join('models', 'throw', 'outer_bullseye')

describe Throw::OuterBullseye do
  it 'should have a fixed score' do
    expect(Throw::OuterBullseye.new.score).to eq(25)
  end
end