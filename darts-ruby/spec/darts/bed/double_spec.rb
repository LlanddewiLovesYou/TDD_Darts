require 'darts'

describe Bed::Double do
  it 'should double a valid bed value' do
    expect(Bed::Double.new(10).bed_score).to eq(20)
  end

  it 'should raise exception when created with bed value just below minimum in range' do
    expect { Bed::Double.new(0) }.to raise_error(ArgumentError, 'Throw must be in range 1..20')
  end

  it 'should raise exception when created with bed value just above maximum in range' do
    expect { Bed::Double.new(21) }.to raise_error(ArgumentError, 'Throw must be in range 1..20')
  end
end