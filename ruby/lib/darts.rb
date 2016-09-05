#!/usr/bin/env ruby

Dir.glob(File.join(File.expand_path(File.dirname(__FILE__)), '**', '*.rb')) { |file| require file }