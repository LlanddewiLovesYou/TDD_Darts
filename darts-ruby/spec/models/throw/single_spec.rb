require File.join('models', 'throw', 'single')

describe Throw::Single do
  it 'should allow a valid score' do
    expect(Throw::Single.new(5).score).to eq(5)
  end

  it 'should raise exception when created with score just below minimum in range' do
    expect {Throw::Single.new(0) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end

  it 'should raise exception when created with score just above maximum in range' do
    expect {Throw::Single.new(21)}.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end
end