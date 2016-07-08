require 'models/throw_inner_ring'

describe ThrowInnerRing do
  it 'should have a fixed score' do
    expect(ThrowInnerRing.new.score).to eq(50)
  end
end