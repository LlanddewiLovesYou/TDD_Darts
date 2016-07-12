require File.join('models', 'throw_outer_bullseye')

describe ThrowOuterBullseye do
  it 'should have a fixed score' do
    expect(ThrowOuterBullseye.new.score).to eq(25)
  end
end