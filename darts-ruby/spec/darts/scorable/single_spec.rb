require 'darts'

describe Scorable::Single do
  it 'should allow a valid bed value' do
    expect(Scorable::Single.new(5).bed_score).to eq(5)
  end

  it 'should raise exception when created with bed value just below minimum in range' do
    expect {Scorable::Single.new(0) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end

  it 'should raise exception when created with bed value just above maximum in range' do
    expect {Scorable::Single.new(21)}.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end
end