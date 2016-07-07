require 'models/double_throw'

describe DoubleThrow do
  it 'should allow a valid score' do
    expect(DoubleThrow.new(10).score).to eq(20)
  end

  it 'should raise exception when created with score just below minimum in range' do
    expect { DoubleThrow.new(0) }.to raise_error(ArgumentError, 'Throw must be in range 1..20')
  end

  it 'should raise exception when created with score just above maximum in range' do
    expect { DoubleThrow.new(21) }.to raise_error(ArgumentError, 'Throw must be in range 1..20')
  end
end