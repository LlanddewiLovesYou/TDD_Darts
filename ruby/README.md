# Ruby Skeleton

This skeleton has been set up to be used with a Ruby Version Manager such as RVM or Rbenv. The skeleton uses `.ruby-gemset` and `.ruby-version` to manage the Gemset and Ruby versions. If you have one of either RVM or rbenv installed and you have also installed the version of Ruby specified in `.ruby-version` you should be good to go.

It is not necessary to have a Ruby Version Manager in order to run the Rspec specs.

### Steps

The steps to run the specs, with and without a version manager is as follows:

1. Using a terminal, change into the `ruby` directory.
2. Install Bundler by running `gem install bundler`.
3. Run `bundle install`
4. Run the specs using `rspec`