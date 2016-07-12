require File.join('models', 'throw', 'triple')

describe Throw::Triple do
  it 'should triple a valid score' do
    expect(Throw::Triple.new(3).bed_score).to eq(9)
  end

  it 'should raise an exception when created with a score just below the minimum allowed' do
    expect { Throw::Triple.new(0) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end

  it 'should raise an exception when created with a score just above the maximum allowed' do
    expect { Throw::Triple.new(21) }.to raise_error(ArgumentError, 'Throw score must be in range 1..20')
  end
end