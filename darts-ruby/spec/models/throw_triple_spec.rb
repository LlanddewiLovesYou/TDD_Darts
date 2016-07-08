require 'models/throw_triple'

describe ThrowTriple do
  it 'should triple a valid score' do
    expect(ThrowTriple.new(3).score).to eq(9)
  end

  it 'should raise an exception when created with a score just below the minimum allowed' do
    expect { ThrowTriple.new(0) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end

  it 'should raise an exception when created with a score just above the maximum allowed' do
    expect { ThrowTriple.new(21) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end
end