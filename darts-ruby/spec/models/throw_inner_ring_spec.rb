require File.join('models', 'throw_inner_bullseye')

describe ThrowInnerBullseye do
  it 'should have a fixed score' do
    expect(ThrowInnerBullseye.new.score).to eq(50)
  end
end