require 'models/single_throw'

describe SingleThrow do
  it 'should a score on the board' do
    expect(SingleThrow.new(5).score).to eq(5)
  end

  it 'should raise exception when created with score of 0' do
    expect {SingleThrow.new(0) }.to raise_error(ArgumentError, 'Throw score must be 1..20')
  end

  it 'should raise exception when created with score of 1' do
    expect {SingleThrow.new(21)}.to raise_error(ArgumentError, 'Throw score must be 1..20')
  end
end