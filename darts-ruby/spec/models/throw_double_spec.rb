require File.join('models', 'throw_double')

describe ThrowDouble do
  it 'should double a valid score' do
    expect(ThrowDouble.new(10).score).to eq(20)
  end

  it 'should raise exception when created with score just below minimum in range' do
    expect { ThrowDouble.new(0) }.to raise_error(ArgumentError, 'Throw must be in range 1..20')
  end

  it 'should raise exception when created with score just above maximum in range' do
    expect { ThrowDouble.new(21) }.to raise_error(ArgumentError, 'Throw must be in range 1..20')
  end
end