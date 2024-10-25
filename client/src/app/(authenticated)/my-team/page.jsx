import { TeamMenu } from '@/components/DropDown/TeamMenu';
import { Meeting } from '@/components/Meeting/Meeting';
import { PlatformButton } from '@/components/PlatformButton/PlatformButton';
import Discord from '/public/images/discord.png';
import Github from '/public/images/github-b.png';
import Slack from '/public/images/slack.png';

export default function MyTeamPage() {
  return (
    <>
      <TeamMenu />
      <div className="mx-auto mb-36 mt-4 w-full max-w-[90%] leading-[14px] text-white">
        <div className="px-3">
          <h1 className="mt-8 text-left text-xl font-semibold text-white">Enlaces rapidos</h1>
        </div>
        <div className="flex items-center py-3">
          <PlatformButton iconSrc={Discord} label="Discord" />
          <PlatformButton iconSrc={Slack} label="Slack" />
          <PlatformButton iconSrc={Github} label="Github" />
        </div>
      </div>
      <Meeting />
    </>
  );
}
