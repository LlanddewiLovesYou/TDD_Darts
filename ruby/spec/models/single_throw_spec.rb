require 'models/single_throw'

describe SingleThrow do
  it 'should allow a valid score' do
    expect(SingleThrow.new(5).score).to eq(5)
  end

  it 'should raise exception when created with score just below minimum in range' do
    expect {SingleThrow.new(0) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end

  it 'should raise exception when created with score just above maximum in range' do
    expect {SingleThrow.new(21)}.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end
end