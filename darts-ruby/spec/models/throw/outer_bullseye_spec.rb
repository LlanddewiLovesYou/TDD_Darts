require File.join('models', 'throw', 'outer_bullseye')

describe Throw::OuterBullseye do
  it 'should have a fixed score' do
    expect(Throw::OuterBullseye.new.bed_score).to eq(25)
  end
end