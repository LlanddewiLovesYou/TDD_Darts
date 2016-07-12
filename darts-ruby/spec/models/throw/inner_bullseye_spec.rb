require File.join('models', 'throw', 'inner_bullseye')

describe Throw::InnerBullseye do
  it 'should have a fixed score' do
    expect(Throw::InnerBullseye.new.score).to eq(50)
  end
end