import Image from 'next/image';

export const PlatformButton = ({ iconSrc, label }) => {
  return (
    <div className="ml-2 flex flex-col items-center">
      <button className="flex size-12 items-center justify-center">
        <Image width={30} height={30} src={iconSrc} alt={`${label} logo`} />
      </button>
      <div className="text-[10px]">{label}</div>
    </div>
  );
};
