require 'darts'

describe Bed::Triple do
  it 'should triple a valid bed value' do
    expect(Bed::Triple.new(3).bed_score).to eq(9)
  end

  it 'should raise an exception when created with a bed value just below the minimum allowed' do
    expect { Bed::Triple.new(0) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end

  it 'should raise an exception when created with a bed value just above the maximum allowed' do
    expect { Bed::Triple.new(21) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end
end