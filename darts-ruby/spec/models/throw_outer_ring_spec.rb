require 'models/throw_outer_ring'

describe ThrowOuterRing do
  it 'should have a fixed score' do
    expect(ThrowOuterRing.new.score).to eq(25)
  end
end